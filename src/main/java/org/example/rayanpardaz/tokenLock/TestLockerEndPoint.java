package org.example.rayanpardaz.tokenLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLockerEndPoint {
    private TokenLock tokenLock;

    @Autowired
    public TestLockerEndPoint(TokenLock tokenLocks) {
        this.tokenLock = tokenLocks;
    }

    @GetMapping("/ten-seconds-method")
    public String tenSecondsMethod(@RequestHeader("token") String token) {
        synchronized (tokenLock.getMethodLock(token)) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ten seconds finished!!";
        }
    }

    @GetMapping("/waiting-method")
    public String waitingMethod(@RequestHeader("token") String token) {
        synchronized (tokenLock.getMethodLock(token)) {
            return "waitingMethod was run after tenSecondMethod action finished!!";
        }
    }
}
