package edu.gemini.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASaburov
 */
public class HelloImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ОЧЕНЬ ВАЖНЫЙ МОМЕНТ - надо заранее установить тип возвращаемой информации
        // чтобы броузер мог правильно его показывать. Здесь у нас будет возвращаться картинка
        // в формате PNG
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        try {
            URL imageURL = HelloImage.class.getResource("map.png");
            BufferedImage bi = ImageIO.read(imageURL);
            ImageIO.setUseCache(false);
            ImageIO.write(bi, "png", out);
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
