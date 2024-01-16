package com.mpxds.apps.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.view.ViewScoped;
//import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MpLineChartController implements Serializable {
    //
    private static final long serialVersionUID = 1L;

    private LineChartModel lineModel;

    private String nome = "Marcus Teste";

    @PostConstruct
    public void init() {
    	//
    	System.out.println("MpLineChartController.init() ...000");

    	this.nome = "Marcus Rodrigues";
    	
        this.lineModel = new LineChartModel();
        
        ChartData data = new ChartData();
        
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Number> values = new ArrayList<>();
        
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        
//      dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setTension(0.1);
        
        data.addChartDataSet(dataSet);
        
        List<String> labels = new ArrayList<>();
        
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        
        data.setLabels(labels);
        
        //Options
        LineChartOptions options = new LineChartOptions(); 
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        
        options.setTitle(title);
        
        this.lineModel.setOptions(options);
        this.lineModel.setData(data);
    }

    public LineChartModel getLineModel() {
    	//
        return this.lineModel;
    }

    public String getNome() {
    	//
        return this.nome;
    }

}