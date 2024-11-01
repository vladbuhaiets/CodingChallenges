package cc.CodingChallenges.rateLimiter.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bucket {
    private AtomicInteger tokens = new AtomicInteger(10);

    public Boolean checkTokensEmpty() {
        return tokens.get() == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void releaseToken() {
        tokens.decrementAndGet();
    }

    public void refillTokens() {
        tokens.getAndUpdate(operand -> {
            if (operand > 10)
                operand++;
            return operand;
        });
    }


}
