package org.openmrs.bot.openmrsgcibot;

public class Message {

    private String id;
    private Double time;
    private String event_type;
    private String author;
    private boolean author_is_student;
    private String task_claimed_by;
    private Long task_instance;
    private String task_definition_name;
    private String task_instance_url;
    private String task_definition_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAuthor_is_student() {
        return author_is_student;
    }

    public void setAuthor_is_student(boolean author_is_student) {
        this.author_is_student = author_is_student;
    }

    public String getTask_claimed_by() {
        return task_claimed_by;
    }

    public void setTask_claimed_by(String task_claimed_by) {
        this.task_claimed_by = task_claimed_by;
    }

    public Long getTask_instance() {
        return task_instance;
    }

    public void setTask_instance(Long task_instance) {
        this.task_instance = task_instance;
    }

    public String getTask_definition_name() {
        return task_definition_name;
    }

    public void setTask_definition_name(String task_definition_name) {
        this.task_definition_name = task_definition_name;
    }

    public String getTask_instance_url() {
        return task_instance_url;
    }

    public void setTask_instance_url(String task_instance_url) {
        this.task_instance_url = task_instance_url;
    }

    public String getTask_definition_url() {
        return task_definition_url;
    }

    public void setTask_definition_url(String task_definition_url) {
        this.task_definition_url = task_definition_url;
    }
}
