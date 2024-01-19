package th.ac.chs.reg.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-Api-Key";
    private static final String EXPECTED_API_KEY = "tm4WyNwsd9H5uQ6RTexqaKBX7GjLvhJpECSzfA28YVDrZ3Fckg"; // Replace with your actual API key

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader(API_KEY_HEADER);

        if (apiKey == null || !apiKey.equals(EXPECTED_API_KEY)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }
}
