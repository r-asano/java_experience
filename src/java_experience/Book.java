package java_experience;

// 練習問題5-1

import java.sql.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Book implements Comparable<Book>, Cloneable{

	private String title;
	private Date publishDate;
	private String commnet;

	// geetter setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getCommnet() {
		return commnet;
	}

	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}


	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	public int compareTo(Book o) {
		return CompareToBuilder.reflectionCompare(this, o);
	}

	public Book clone() {
		Book b = new Book();
		b.title = title;
		b.publishDate = (Date) this.publishDate.clone();
		b.commnet = commnet;
		return b;
	}


}
