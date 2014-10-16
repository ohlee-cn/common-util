package cn.ohlee.common.util;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by brody on 14-10-15.
 */
public class JsonUtilTest {
    static enum Status {
        ACTIVE, DISABLED;
        public String toString() {
            return name().toLowerCase();
        }
    }

    static class User {
        private String username;
        private String password;
        private int age;
        private Status status;
        private String info;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

    }

    /**
     * test user
     */
    private User user;
    /**
     * test json
     */
    private String json;
    /**
     * test json
     */
    private String jsonList;
    /**
     * setup
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("测试");
        user.setPassword("password");
        user.setStatus(Status.ACTIVE);
        user.setAge(2);
        json = "{\"username\":\"测试\",\"password\":\"password\",\"age\":2,\"status\":\"ACTIVE\",\"info\":null}";
        jsonList = "[{\"username\":\"测试1\",\"password\":\"password1\",\"age\":2,\"status\":\"ACTIVE\",\"info\":null}, {\"username\":\"测试2\",\"password\":\"password2\",\"age\":3,\"status\":\"DISABLED\",\"info\":\"第二个\"}]";
    }

    /**
     * Test method for {@link cn.ohlee.common.util.JsonUtil#json2GenericObject(java.lang.String, org.codehaus.jackson.type.TypeReference)}.
     */
    @Test
    public void testJson2GenericObject() {
        List<User> userList = JsonUtil.json2GenericObject(jsonList, new TypeReference<List<User>>(){});
        Assert.assertEquals(userList.size(), 2);
        Assert.assertEquals(userList.get(0).getAge(), 2);
        Assert.assertFalse(userList.get(0).getStatus().equals(Status.DISABLED));
        Assert.assertEquals(userList.get(1).getStatus(), Status.DISABLED);
    }

    /**
     * Test method for {@link cn.ohlee.common.util.JsonUtil#toJson(java.lang.Object)}.
     */
    @Test
    public void testToJson() {
        String str = JsonUtil.toJson(null);
        Assert.assertEquals(str, "null");
        str = JsonUtil.toJson(user);
        Assert.assertEquals(str, json);
        User u = (User) JsonUtil.json2Object(str, User.class);
        Assert.assertTrue((u.getAge() == 2 && u.getUsername().equals(user.getUsername())));
    }

    /**
     * Test method for {@link cn.ohlee.common.util.JsonUtil#json2Object(java.lang.String, java.lang.Class)}.
     */
    @Test
    public void testJson2Object() {
        User u = (User) JsonUtil.json2Object(json, User.class);
        Assert.assertTrue((u.getAge() == 2 && u.getAge() == user.getAge()));
        Assert.assertTrue(u.getStatus() == user.getStatus());
    }

    /**
     * test null object
     */
    @Test
    public void testNull(){
        User u = null;
        String s = JsonUtil.toJson(null);
        User u2 =(User) JsonUtil.json2Object(s, User.class);
        Assert.assertEquals(u, u2);
    }
}
