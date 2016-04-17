package ohtu;

public class Submission {

    private String student_number;
    private Integer id;
    private String last_ame;
    private String first_name;
    private String week;
    private Integer points;
    private String identifier;
    private Integer hours;
    private String comments;
    private String email;
    private Boolean a1;
    private Boolean a2;
    private Boolean a3;
    private Boolean a4;
    private Boolean a5;
    private Boolean a6;
    private Boolean a7;
    private Boolean a8;
    private Boolean a9;
    private Boolean a10;
    private Boolean a11;
    private Boolean a12;
    private Boolean a13;
    private Boolean a14;
    private Boolean a15;
    private Boolean a16;
    private Boolean a17;
    private Boolean a18;
    private Boolean a19;
    private Boolean a20;
    private Boolean a21;
    private String created_at;
    private String updated_at;
    private Integer course_id;
    private String github;
    private Integer student_id;
    private String challenging;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("tehtyjä tehtäviä yhteensä: " + countExercisesDone() + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + getExercisesThatWereDone());
        return sb.toString();
    }
    
    private String getExercisesThatWereDone() {
        String exercises = "";
        if (exerciseDone(a1)) exercises += "a1 ";
        if (exerciseDone(a2)) exercises += "a2 ";
        if (exerciseDone(a3)) exercises += "a3 ";
        if (exerciseDone(a4)) exercises += "a4 ";
        if (exerciseDone(a5)) exercises += "a5 ";
        if (exerciseDone(a6)) exercises += "a6 ";
        if (exerciseDone(a7)) exercises += "a7 ";
        if (exerciseDone(a8)) exercises += "a8 ";
        if (exerciseDone(a9)) exercises += "a9 ";
        if (exerciseDone(a10)) exercises += "a10 ";
        if (exerciseDone(a11)) exercises += "a11 ";
        if (exerciseDone(a12)) exercises += "a12 ";
        if (exerciseDone(a13)) exercises += "a13 ";
        if (exerciseDone(a14)) exercises += "a14 ";
        if (exerciseDone(a15)) exercises += "a15 ";
        if (exerciseDone(a16)) exercises += "a16 ";
        if (exerciseDone(a17)) exercises += "a17 ";
        if (exerciseDone(a18)) exercises += "a18 ";
        if (exerciseDone(a19)) exercises += "a19 ";
        if (exerciseDone(a20)) exercises += "a20 ";
        if (exerciseDone(a21)) exercises += "a21 ";
        
        return exercises;
    }
    
    public int countExercisesDone() {
        int done = 0;
        if (exerciseDone(a1)) done++;
        if (exerciseDone(a2)) done++;
        if (exerciseDone(a3)) done++;
        if (exerciseDone(a4)) done++;
        if (exerciseDone(a5)) done++;
        if (exerciseDone(a6)) done++;
        if (exerciseDone(a7)) done++;
        if (exerciseDone(a8)) done++;
        if (exerciseDone(a9)) done++;
        if (exerciseDone(a10)) done++;
        if (exerciseDone(a11)) done++;
        if (exerciseDone(a12)) done++;
        if (exerciseDone(a13)) done++;
        if (exerciseDone(a14)) done++;
        if (exerciseDone(a15)) done++;
        if (exerciseDone(a16)) done++;
        if (exerciseDone(a17)) done++;
        if (exerciseDone(a18)) done++;
        if (exerciseDone(a19)) done++;
        if (exerciseDone(a20)) done++;
        if (exerciseDone(a21)) done++;
        
        return done;
    }
    
    private boolean exerciseDone(Boolean exercise) {
        return exercise != null && exercise == true;
    }

    public Integer getId() {
        return id;
    }

    public String getLast_ame() {
        return last_ame;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getWeek() {
        return week;
    }

    public Integer getPoints() {
        return points;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Integer getHours() {
        return hours;
    }

    public String getComments() {
        return comments;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getA1() {
        return a1;
    }

    public Boolean getA2() {
        return a2;
    }

    public Boolean getA3() {
        return a3;
    }

    public Boolean getA4() {
        return a4;
    }

    public Boolean getA5() {
        return a5;
    }

    public Boolean getA6() {
        return a6;
    }

    public Boolean getA7() {
        return a7;
    }

    public Boolean getA8() {
        return a8;
    }

    public Boolean getA9() {
        return a9;
    }

    public Boolean getA10() {
        return a10;
    }

    public Boolean getA11() {
        return a11;
    }

    public Boolean getA12() {
        return a12;
    }

    public Boolean getA13() {
        return a13;
    }

    public Boolean getA14() {
        return a14;
    }

    public Boolean getA15() {
        return a15;
    }

    public Boolean getA16() {
        return a16;
    }

    public Boolean getA17() {
        return a17;
    }

    public Boolean getA18() {
        return a18;
    }

    public Boolean getA19() {
        return a19;
    }

    public Boolean getA20() {
        return a20;
    }

    public Boolean getA21() {
        return a21;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public String getGithub() {
        return github;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getChallenging() {
        return challenging;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLast_ame(String last_ame) {
        this.last_ame = last_ame;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setA1(Boolean a1) {
        this.a1 = a1;
    }

    public void setA2(Boolean a2) {
        this.a2 = a2;
    }

    public void setA3(Boolean a3) {
        this.a3 = a3;
    }

    public void setA4(Boolean a4) {
        this.a4 = a4;
    }

    public void setA5(Boolean a5) {
        this.a5 = a5;
    }

    public void setA6(Boolean a6) {
        this.a6 = a6;
    }

    public void setA7(Boolean a7) {
        this.a7 = a7;
    }

    public void setA8(Boolean a8) {
        this.a8 = a8;
    }

    public void setA9(Boolean a9) {
        this.a9 = a9;
    }

    public void setA10(Boolean a10) {
        this.a10 = a10;
    }

    public void setA11(Boolean a11) {
        this.a11 = a11;
    }

    public void setA12(Boolean a12) {
        this.a12 = a12;
    }

    public void setA13(Boolean a13) {
        this.a13 = a13;
    }

    public void setA14(Boolean a14) {
        this.a14 = a14;
    }

    public void setA15(Boolean a15) {
        this.a15 = a15;
    }

    public void setA16(Boolean a16) {
        this.a16 = a16;
    }

    public void setA17(Boolean a17) {
        this.a17 = a17;
    }

    public void setA18(Boolean a18) {
        this.a18 = a18;
    }

    public void setA19(Boolean a19) {
        this.a19 = a19;
    }

    public void setA20(Boolean a20) {
        this.a20 = a20;
    }

    public void setA21(Boolean a21) {
        this.a21 = a21;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setChallenging(String challenging) {
        this.challenging = challenging;
    }

}
