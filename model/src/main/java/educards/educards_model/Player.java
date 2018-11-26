package educards.educards_model;

public class Player {
	
	private Integer idPlayer;
	private String image;
	private String name;
	private Integer year;
	private String password;

	public Player (){}

	public Player(String name, String password, Integer age, String image) {
		this.name = name;
        this.year = age;
        this.image = image;
        this.password = password;
	}

	public Player(Integer id, String image, String name, Integer age, String password) {
		this.idPlayer = id;
		this.image = image;
		this.name = name;
		this.year = age;
		this.password = password;
	}

	public Integer getId() {
		return idPlayer;
	}

	public String getImage() {
		return image;
	}
	
	public String getUsername() {
		return name;
	}
	
	public Integer getAge() {
		return year;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void editName(String name) {
		if(!name.isEmpty()) {this.name = name;}
	}
	
	public void editPassword(String password) {
		if(!name.isEmpty()) {this.password = password;}
	}
	
	public void editYear(Integer year) {
		if(year>1900 && year<2018) {this.year = year;}
	}
}