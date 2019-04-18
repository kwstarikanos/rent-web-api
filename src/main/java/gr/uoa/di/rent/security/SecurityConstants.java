package gr.uoa.di.rent.security;

public class SecurityConstants {

    public static final String SECRET = "Rent.JwtSecret-ys09";
    public static final long   EXPIRATION_TIME = 259_200_000; // 3 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String SIGN_UP_URL = "/api/auth/signup";
    public static final String SIGN_IN_URL = "/api/auth/signin";

}