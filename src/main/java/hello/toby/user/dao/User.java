package hello.toby.user.dao;

public class User {
    private String id;
    private String name;
    private String password;

    /*
    * 디폴트 생성자 : 자바빈은 파라미터가 없는 디폴트 생성자를 가지고 있어야 한다. 툴이나 프레임워크에서 리플렉션을 이용해 오브젝트를 생성하기 때문에 필요하다.
    * */
    public User() {
    }

    /*
    * 프로퍼티 : 자바빈이 노출하는 이름을 가진 속성을 프로퍼티라고 한다. 프로퍼티는 set으로 시작하는 setter와 get으로 시작하는 getter를 이용해 수정또는 조회 할 수 있다.
    * */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
