package persistence.domain;

import util.ClassType;

import javax.persistence.*;

@Entity
public class Avatar {

    @Id
    @Column(name = "avatar_name")
    private String avatarName;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_name")
    private ClassType className;

    @Column(name = "avatar_level")
    private int avatarLevel;

    public Avatar() {

    }

    public Avatar(String avatarName, ClassType className, int avatarLevel) {
        this.avatarName = avatarName;
        this.className = className;
        this.avatarLevel = avatarLevel;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public ClassType getClassName() {
        return className;
    }

    public void setClassName(ClassType className) {
        this.className = className;
    }

    public int getAvatarLevel() {
        return avatarLevel;
    }

    public void setAvatarLevel(int avatarLevel) {
        this.avatarLevel = avatarLevel;
    }
}