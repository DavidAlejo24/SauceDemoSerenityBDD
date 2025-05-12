package UI;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPageUI {

    public static final Target TITULO_PRINCIPAL_PRODUCTOS = Target.the("Titulo de Productos").locatedBy("//span[@class='title' and contains(text(),'Products')]");
    public static final Target TITUTOS_PRODUCTOS = Target.the("Titulos de Productos").locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name ']");
    public static final Target BTN_ADD_CARD_PRODUCTO = Target.the("Boton de 'Agregar al Carrito' del Productos {0}").locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name ' and contains(text(),'{0}')]/../../..//button");
    public static final Target TITULO_PRODUCTO_AGREGADO = Target.the("Titulo '{0}' del Producto agregado").locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name ' and contains(text(),'{0}')]");
    public static final Target DESCRIPCION_PRODUCTO_AGREGADO = Target.the("Descripcion '{0}' del Producto agregado").locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name ' and contains(text(),'{0}')]/../..//div[@class='inventory_item_desc']");
    public static final Target PRECIO_PRODUCTO_AGREGADO = Target.the("Precio '{0}' del Producto agregado").locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name ' and contains(text(),'{0}')]/../../..//div[@class='inventory_item_price']");


}
