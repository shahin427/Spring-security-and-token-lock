package org.example.rayanpardaz.tokenLock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenLock {
    private Map<String, Object> locker = new HashMap<>();
    public Object getMethodLock(String token) {
        synchronized (locker) {
            // Retrieve or create lock object associated with the token
            return locker.computeIfAbsent(token, k -> new Object());
        }
    }
}
