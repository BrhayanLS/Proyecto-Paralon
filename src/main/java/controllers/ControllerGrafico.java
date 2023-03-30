package controllers;

import entities.ProductosInventario;
import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import services.ProductosInventarioFacade;

@Named(value = "controllerGrafico")
@ViewScoped
public class ControllerGrafico implements Serializable {

    private BarChartModel barModel;

    public void listar() {
        ProductosInventarioFacade proFa;
        List<ProductosInventario> lista;

        try {
            proFa = new ProductosInventarioFacade();
            lista = proFa.ventas();
            graficar(lista);
        } catch (SQLException e) {
        }
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    private void graficar(List<ProductosInventario> lista) {
        barModel = new BarChartModel();

        ChartSeries stockSeries = new ChartSeries();
        stockSeries.setLabel("Stock");

        for (ProductosInventario pro : lista) {
            stockSeries.set(pro.getNombre(), pro.getStock());
        }

        barModel.addSeries(stockSeries);

        barModel.setTitle("Nombre");
        barModel.setLegendPosition("e");
    }
}
