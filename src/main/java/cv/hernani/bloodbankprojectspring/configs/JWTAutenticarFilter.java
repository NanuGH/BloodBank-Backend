package cv.hernani.bloodbankprojectspring.configs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final long TOKEN_EXPIRACAO = 86400000L;
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";
    public static final String SECRET = "SECRET_KEY";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            EmployeeModel employee = new ObjectMapper()
                    .readValue(request.getInputStream(), EmployeeModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    employee.getEmail(),
                    employee.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar funcionário", e);
        }

    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,
                                            FilterChain chain,Authentication authResult) throws IOException,
                                                                                            ServletException {

      DetalhEmployeeData emplData = (DetalhEmployeeData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(emplData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA.getBytes()));
               //.sign(Algorithm.HMAC512(SECRET.getBytes()));

        String body = "{ token: " + token + " }";
        JSONObject jsonObject = new JSONObject(body);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
    }

}