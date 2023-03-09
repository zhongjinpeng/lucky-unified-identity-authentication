package io.lucky.unified.identity.authentication.controller;

import io.lucky.common.model.response.LuckyBaseResponse;
import io.lucky.unified.identity.authentication.exception.UnifiedIdentityAuthenticationException;
import io.lucky.unified.identity.authentication.model.request.LoginRequest;
import io.lucky.unified.identity.authentication.model.request.PasswordLoginRequest;
import io.lucky.unified.identity.authentication.model.request.VerificationCodeLoginRequest;
import io.lucky.unified.identity.authentication.model.vo.TokenVO;
import io.lucky.utils.GsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "登录相关接口")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("验证码登录")
    @PostMapping("/verificationCode")
    public LuckyBaseResponse<TokenVO> verificationCodeLogin(@RequestBody VerificationCodeLoginRequest verificationCodeLoginRequest, HttpServletRequest request) throws Exception {
        TokenVO vo = GsonUtil.GsonToBean(GsonUtil.GsonToString(forwardLoginRequest(request,verificationCodeLoginRequest)), TokenVO.class);
        return LuckyBaseResponse.success(vo);
    }

    @ApiOperation("密码登录")
    @PostMapping("/password")
    public LuckyBaseResponse<TokenVO> passwordLogin(@RequestBody PasswordLoginRequest passwordLoginRequest, HttpServletRequest request) throws Exception {
        TokenVO vo = GsonUtil.GsonToBean(GsonUtil.GsonToString(forwardLoginRequest(request,passwordLoginRequest)), TokenVO.class);
        return LuckyBaseResponse.success(vo);
    }

    private Map forwardLoginRequest(HttpServletRequest request, LoginRequest loginRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(loginRequest.clientId(), loginRequest.clientSecret());
        MultiValueMap<String, Object> requestMap = new LinkedMultiValueMap();
        Map<String, Object> paramMap = GsonUtil.GsonToBean(GsonUtil.GsonToString(loginRequest), HashMap.class);
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            requestMap.add(entry.getKey(), entry.getValue());
        }
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/authentication/oauth/token";
        try {
            RequestEntity requestEntity = RequestEntity
                    .post(new URI(url))
                    .headers(headers)
                    .accept(MediaType.ALL).acceptCharset(StandardCharsets.UTF_8)
                    .body(requestMap);

            ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);
            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                throw new UnifiedIdentityAuthenticationException("登录失败");
            }
            return responseEntity.getBody();
        } catch (URISyntaxException e){
            throw new UnifiedIdentityAuthenticationException(e.getMessage());
        } catch (HttpClientErrorException e){
            throw new UnifiedIdentityAuthenticationException(e.getMessage());
        }
    }
}
