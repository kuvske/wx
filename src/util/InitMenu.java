package util;

import button.*;

public class InitMenu {
   public static Menu initmenu(){
	   Menu menu = new Menu();
	   
	   ClickButton clickbutton11 = new ClickButton();
	   clickbutton11.setName("click�¼�11");
	   clickbutton11.setType("click");
	   clickbutton11.setKey("11");
	   
	   ClickButton clickbutton12 = new ClickButton();
	   clickbutton12.setName("ɨ���¼�12");
	   clickbutton12.setType("location_select");
	   clickbutton12.setKey("12");
	   
	   ViewButton viewbutton = new ViewButton();
	   viewbutton.setName("view�¼�");
	   viewbutton.setType("view");
	   viewbutton.setUrl("http://www.163.com");
	   
	   ViewButton viewbutton1 = new ViewButton();
	   viewbutton1.setName("view�¼�1");
	   viewbutton1.setType("view");
	   viewbutton1.setUrl("http://www.ljbbj.com");
	   
	   Button button = new Button();
	   button.setSub_button(new Button[]{viewbutton,viewbutton1});
	   button.setName("����˵�");
	   
	   menu.setButton(new Button[]{button,clickbutton11,clickbutton12});
	   
	   return menu;
   }
}
