package Winter2022.f;

public class User {
    private final int id;
    private final String name;

    public User(UserBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    static class UserBuilder{

        private final int id;
        private final String name;

        public UserBuilder(int id, String name){
            this.id=id;
            this.name=name;
        }

        User build(){
            return new User(this);

        }

    }




}
