
public class Groups {
    String GroupID;
    String Code;
    String Groupname;

    public Groups(){

    }

    public Groups(String groupID, String groupname,String code) {
        GroupID = groupID;
        Code=code;
        Groupname = groupname;
    }

    public String getGroupID() {
        return GroupID;
    }

    public String getGroupname() {
        return Groupname;
    }

    public String getCode() {
        return Code;
    }
}
