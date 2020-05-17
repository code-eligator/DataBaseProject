package ConnectEx;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VisualizeData {

	public VisualizeData() {}
	
	// getChart() 메서드. Chart 를 만들어서 리턴함
	
    public JFreeChart getChart() {

        JFreeChart chart = ChartFactory.createBarChart(/*getClass().getName()*/"Average limit by age group", // title
                                "age group", // categoryAxisLabel
                                "Limit", // valueAxisLabel
                                getDataSet(), // dataset
                                PlotOrientation.VERTICAL,// orientation
                                true, // legend
                                true, // tooltips
                                false); // url
      
        return chart;
    }

    private DefaultCategoryDataset getDataSet() {
    	
    	Select data = new Select();
    	
    	int[] avg = data.sqlSelect();
    	
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        String category1 = "";
        String test1 = "20s";
        String test2 = "30s";
        String test3 = "40s";
        String test4 = "50s";
        String test5 = "60s";
      
        // addValue() 메서드를 이용해서 값을 추가함
        dataSet.addValue(avg[0], category1, test1);
        dataSet.addValue(avg[1], category1, test2);
        dataSet.addValue(avg[2], category1, test3);
        dataSet.addValue(avg[3], category1, test4);
        dataSet.addValue(avg[4], category1, test5);
   
        return dataSet;
    }  

 // 메인 메서드. 챠트 프레임을 보여줌
    public static void main(String[] args) {
    	
        JFreeChart chart = new VisualizeData().getChart();
        ChartFrame cf = new ChartFrame("My Chart", chart);
        cf.setSize(400, 400);
        cf.setVisible(true);
    }
    
}

