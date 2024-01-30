package th.ac.chs.reg.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.repository.UserRepository;
import th.ac.chs.reg.service.JwtService;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-Api-Key";
    private static final String EXPECTED_API_KEY = "tm4WyNwsd9H5uQ6RTexqaKBX7GjLvhJpECSzfA28YVDrZ3Fckg"; // Replace with your actual API key
    @Autowired
    private UserRepository userRepository;

    JwtService jwtService = new JwtService();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader(API_KEY_HEADER);
        String jwtToken = request.getHeader("Authorization"); // Assuming JWT is sent in the Authorization header

        if (apiKey == null || !apiKey.equals(EXPECTED_API_KEY)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            String token = jwtToken.substring(7);

            try {
                if (!jwtService.isTokenExpired(token)) {
                    return true;
                }
            } catch (io.jsonwebtoken.security.SignatureException signatureException) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                System.out.println("Someone try to use Illegal token : "+ jwtToken);
                return false;
            } catch (Exception exception) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return false;
            }

        }

        return false;
    }
}
