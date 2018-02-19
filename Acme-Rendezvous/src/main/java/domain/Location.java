
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Embeddable
@Access(AccessType.PROPERTY)
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

	@Range(min = (long) -89.999999, max = (long) 90.000000)
	@Digits(integer = 2, fraction = 6)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	@Range(min = (long) -179.999999, max = (long) 180.000000)
	@Digits(integer = 3, fraction = 6)
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.latitude == null) ? 0 : this.latitude.hashCode());
		result = prime * result + ((this.longitude == null) ? 0 : this.longitude.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Location other = (Location) obj;
		if (this.latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!this.latitude.equals(other.latitude))
			return false;
		if (this.longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!this.longitude.equals(other.longitude))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

}
