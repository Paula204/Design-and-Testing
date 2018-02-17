
package domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Location {

	private String	name;
	private Double	latitude;
	private Double	longitude;


	@NotBlank
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	@NotNull
	@Range(min = (long) -89.99999, max = (long) 90.0)
	public Double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	@NotNull
	@Range(min = (long) -179.99999, max = (long) 180.0)
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}
}
