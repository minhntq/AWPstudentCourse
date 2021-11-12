package edu.hccs.myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Book {
	private String title;
    private int noOfPages;
    @Autowired
    List<Author> authors;
    List<Publisher> publisher;

    public List<Publisher> getPublisher() {
		return publisher;
	}

	public void setPublisher(List pub1) {
		this.publisher = pub1;
	}

	public Book() {
        System.out.println("I am in constructor");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

	@Override
	public String toString() {
		return "Book [title=" + title + ", noOfPages=" + noOfPages + ", authors=" + authors + ", publisher=" + publisher
				+ "]";
	}

    
}
