package com.albert;

import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.albert.ui.SetWindow;

import net.sf.jasperreports.view.JasperViewer;



public class Application {
	private static Logger logger = Logger.getLogger(Application.class);
	public static void main(String[] args) {
		AppContext context = AppContext.INSTANCE();
		SetWindow window;
        try {
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            UIManager.put("ToolBar.isPaintPlainBackground", Boolean.TRUE);
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
    			JasperViewer.setDefaultLookAndFeelDecorated(false);
    			window = context.getWindow();
            String url = null;
            if(args.length==0) {
            		window.visible(true);
            }else {
	            	for(String arg : args){
                    url = arg.substring(arg.indexOf(":")+3);
                    logger.info(arg);
                }
                context.print(url);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        } 
	    
	}
}