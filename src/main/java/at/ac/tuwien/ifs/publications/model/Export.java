package at.ac.tuwien.ifs.publications.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by xlin on 29.01.2016.
 */
@XmlRootElement(name="export")
@XmlAccessorType(XmlAccessType.FIELD)
public class Export {

	@XmlElement(name="export_info")
	private String info;

	@XmlElement(name="export_datum")
	private String date;

	@XmlElement(name="publikation")
	private List<String> publications;

//	@XmlElementWrapper(name="statistik")
	@XmlElement(name="statistik")
	private String stats;

	@Override
	public String toString() {
		return info + " : " + date + " : " + publications + " : " + stats;
	}
}
