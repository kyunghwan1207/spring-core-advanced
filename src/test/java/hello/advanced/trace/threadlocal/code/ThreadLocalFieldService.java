package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalFieldService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();
    public String logic(String name) {
        log.info("저장 name = {} -> nameStroe = {}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStroe = {}", nameStore.get());
        return name;
    }

    private void sleep(int mullis) {
        try {
            Thread.sleep(mullis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
