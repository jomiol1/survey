package com.survey.services.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @author jose m oliveros
*/
@Entity
@Data
@Table(
       name = "question")
public class QuestionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id")
    @OneToMany(
            fetch = FetchType.LAZY)
	private List<QuestionAnswerEntity> questionAnsweId;
    	
}
