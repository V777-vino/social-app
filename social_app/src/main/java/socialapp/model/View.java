package socialapp.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class View {
	private String name;
	private String message;
	private String status;
	private LocalDate createdDate;
	private LocalDate postedDate;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public void print(ArrayList<View> view) throws IOException {
		try {
			for (View v : view) {
				String allPost = "name=" + v.getName() + ", message=" + v.getMessage() + ", status=" + v.getStatus()
						+ ", createdDate=" + v.getCreatedDate() + ", postedDate=" + v.getPostedDate() + ", id="
						+ v.getId();
				byte[] content = allPost.getBytes();
				Path path = Paths.get("View.txt");
				FileWriter writer = new FileWriter("View.txt");
				writer.write(allPost + System.lineSeparator());
				System.out.println(allPost);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
