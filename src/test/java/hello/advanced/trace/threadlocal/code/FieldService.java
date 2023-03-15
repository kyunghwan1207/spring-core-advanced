package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;
    public String logic(String name) {
        log.info("저장 name = {} -> nameStroe = {}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStroe = {}", nameStore);
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
