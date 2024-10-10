package springboot.spring_advanced1.testconfig;

public class MemberService {

    private final MemberRepositroy memberRepositroy;

    public MemberService(MemberRepositroy memberRepositroy) {
        this.memberRepositroy = memberRepositroy;
    }

    public MemberRepositroy getMemberRepositroy() {
        return memberRepositroy;
    }
}
