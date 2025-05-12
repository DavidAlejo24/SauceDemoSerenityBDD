package UI;

import net.serenitybdd.screenplay.targets.Target;

public class CartPageUI {

    //Product and Cart Pages
    public static final Target ENLACE_CARRITO_COMPRAS = Target.the("Enlace al Carrito de Compras").locatedBy("//div[@id='shopping_cart_container']//a");
    public static final Target TITULO_GENERAL = Target.the("Titulo de Detalle de Productos").locatedBy("//span[@class='title']");
    public static final Target TITULO_PRODUCTO_ACTUAL_CARRITO = Target.the("Titulo {0} del Producto Actual del Carrito").locatedBy("//div[@class='cart_item'][{0}]//div[@class='inventory_item_name']");
    public static final Target DESCRIPCION_PRODUCTO_ACTUAL_CARRITO = Target.the("Descripción {0} del Producto Actual del Carrito").locatedBy("//div[@class='cart_item'][{0}]//div[@class='inventory_item_desc']");
    public static final Target PRECIO_PRODUCTO_ACTUAL_CARRITO = Target.the("Precio {0} del Producto Actual del Carrito").locatedBy("//div[@class='cart_item'][{0}]//div[@class='inventory_item_price']");
    public static final Target BTN_GO_CHECKOUT = Target.the("Boton Continuar - Checkout").locatedBy("//button[@id='checkout']");


    //Checkout Page
    public static final Target INPUT_FIRST_NAME = Target.the("Input de Nombre").locatedBy("//input[@id='first-name']");
    public static final Target INPUT_LAST_NAME = Target.the("Input de Apellido").locatedBy("//input[@id='last-name']");
    public static final Target INPUT_POSTAL_CODE = Target.the("Input de Codigo Postal").locatedBy("//input[@id='postal-code']");
    public static final Target BTN_CONTINUE = Target.the("Boton Continuar - Checkout").locatedBy("//input[@id='continue']");

    //Overview Page
    public static final Target LABEL_ITEM_TOTAL = Target.the("Valor de los productos").locatedBy("//div[@class='summary_subtotal_label']");
    public static final Target LABEL_IMPUESTOS = Target.the("Valor del Impuesto").locatedBy("//div[@class='summary_tax_label']");
    public static final Target LABEL_TOTAL_MAS_IMPUESTO = Target.the("Valor total de los productos con Impuestos").locatedBy("//div[@class='summary_total_label']");
    public static final Target BTN_FINISH = Target.the("Boton Finalizar - Overview").locatedBy("//button[@id='finish']");

    //Checkout complete page

    public static final Target LABEL_COMPLETE_TITULO = Target.the("Titulo de compra exitosa").locatedBy("//h2[@class='complete-header']");
    public static final Target LABEL_COMPLETE_DESCRIPCION = Target.the("Descripcion de Compra exitosa").locatedBy("//div[@class='complete-text']");
    public static final Target BTN_BACK_HOME = Target.the("Boton Regresar al Home").locatedBy("//button[@id='back-to-products']");



}
