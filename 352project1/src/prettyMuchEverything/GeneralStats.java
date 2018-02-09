package prettyMuchEverything;

import java.util.ArrayList;

import javafx.scene.chart.XYChart.Data;

public class GeneralStats {
	int day;
	double height;
	ArrayList<StatTracker> stats;

	public GeneralStats() {
		day = 1;
		stats = new ArrayList<StatTracker>();
		height = 250;
	}

	public int getDay() {
		return day;
	}

	public void nextDay() {
		if (dayReady()) {
			for (StatTracker s : stats) {
				s.getSeries().getData().add(new Data(day + "", s.getAmount())); //https://www.youtube.com/watch?v=CMmeFZyWWSI
				s.setAmount(-1);
			}
			day += 1;
		}
	}

	public ArrayList<StatTracker> getStats() {
		return stats;
	}

	public void addStat(StatTracker stat) {
		stats.add(stat);
	}

	public boolean dayReady() {
		boolean ready = true;
		for (StatTracker s : stats) {
			if (s.getAmount() < 0) {
				ready = false;
			}
		}
		return ready;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double newHeight) {
		height = newHeight;
	}
}
