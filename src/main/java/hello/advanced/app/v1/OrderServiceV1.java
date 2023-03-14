package hello.advanced.app.v1;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final HelloTraceV1 trace;
    private final OrderRepositoryV1 orderRepository;
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV1-orderItem");
            orderRepository.save(itemId);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져줘야한다! 여기서 에러 먹어버리면 안됨!
        }

    }

}
