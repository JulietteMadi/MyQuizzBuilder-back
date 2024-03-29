package co.simplon.myquizzbuilder.dtos.manager;

import java.util.List;

public class ManagerItemsVueDto {

    List<Long> quizIds;

    List<Long> topicIds;

    public List<Long> getQuizIds() {
	return quizIds;
    }

    public void setQuizIds(List<Long> quizIds) {
	this.quizIds = quizIds;
    }

    public List<Long> getTopicIds() {
	return topicIds;
    }

    public void setTopicIds(List<Long> topicIds) {
	this.topicIds = topicIds;
    }

    @Override
    public String toString() {
	return "{quizIds=" + quizIds + ", topicIds="
		+ topicIds + "}";
    }

}
