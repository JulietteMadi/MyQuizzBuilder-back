package co.simplon.myquizzbuilder.dtos.manager;

import java.util.List;

public class ManagerItemsVueDto {

    List<Long> quizIds;

    public List<Long> getQuizIds() {
	return quizIds;
    }

    public void setQuizIds(List<Long> quizIds) {
	this.quizIds = quizIds;
    }

    @Override
    public String toString() {
	return "{quizIds=" + quizIds + "}";
    }

    // List<Long> getTopicIds();

}
