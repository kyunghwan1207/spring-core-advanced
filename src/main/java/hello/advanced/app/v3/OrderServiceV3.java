package hello.advanced.app.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final LogTrace trace;
    private final OrderRepositoryV3 orderRepository;
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV3-orderItem");
            orderRepository.save(itemId);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져줘야한다! 여기서 에러 먹어버리면 안됨!
        }
    }
}
