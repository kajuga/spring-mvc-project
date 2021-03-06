package com.fedorov.hibernate.hb_03_one_to_many;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail", schema = "hb_03_one_to_many")
public class InstructorDetail_03 {

    //annotate the class an entities and map to db tables

    //define the fields

    //annotate the fields with db column names

    //create constructors

    //generate getter/setter methods

    //generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    //add @OneToOne annotation
    //this delete all entities (Instructor and linked instructro Detail)
    //@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    //this - only instructorDetail
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor_03 instructor;




    public InstructorDetail_03() {
    }

    public InstructorDetail_03(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor_03 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor_03 instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
