package springboot.spring_advanced1.testconfig;

public class OrderService {
    private final MemberRepositroy memberRepositroy;

    public OrderService(MemberRepositroy memberRepositroy) {
        this.memberRepositroy = memberRepositroy;
    }

    public MemberRepositroy getMemberRepositroy() {
        return memberRepositroy;
    }
}
