package co.simplon.myquizzbuilder.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "provide", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "guide_id"))
    private List<Guide> guides;

    public Long getTopic_id() {
	return topic_id;
    }

    public void setTopic_id(Long topic_id) {
	this.topic_id = topic_id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Guide> getGuides() {
	return guides;
    }

    public void setGuides(List<Guide> guides) {
	this.guides = guides;
    }

    @Override
    public String toString() {
	return "{topic_id=" + topic_id + ", name=" + name
		+ ", guides=" + guides + "}";
    }

}
