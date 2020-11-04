package kata3_is2;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void execute(){
        this.setVisible(true);
    }

    private JPanel createPanel() {
        //ChartPanel chartPanel = new ChartPanel(createChart(createDataset())); // diagrama de barras
        ChartPanel chartPanel = new ChartPanel(createPieChart3D(createPieDataset())); // diagrama de tarta
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram",
                "email domains",
                "nº emails",
                dataSet,
                PlotOrientation.VERTICAL,
                false,
                false,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private JFreeChart createPieChart3D(PieDataset dataSet){
        JFreeChart pieChart = ChartFactory.createPieChart3D("JFreeChart PieChart", dataSet);
        return pieChart;
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
    
    private PieDataset createPieDataset(){
        DefaultPieDataset pds = new DefaultPieDataset();
        for (String key : histogram.keySet()) {
            pds.setValue(key, histogram.get(key));
        }
        return pds;
    }
}
