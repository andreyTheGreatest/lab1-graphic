import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Applet implements ActionListener {
    private TransformGroup ViewTransformGroup = new TransformGroup();
    private Transform3D treeTransform3D = new Transform3D();
    private Timer timer = new Timer(50, this);
    private double angleY = 0;
    private double angleX = 0;
    private boolean rotateY = true;
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        timer.start();
        BranchGroup scene = createSceneGraph();
        SimpleUniverse universe = new SimpleUniverse();
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(scene);
    }
    public BranchGroup createSceneGraph() {
        BranchGroup group = new BranchGroup();
        ViewTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        createView();
        group.addChild(ViewTransformGroup);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(0.75f, 0.8f, 1.4f);
        Vector3f light1Direction = new Vector3f(2.0f, -6.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color,
                light1Direction);
        light1.setInfluencingBounds(bounds);
        group.addChild(light1);
        Color3f ambientColor = new Color3f(0.5f, 0.5f, 0.5f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        group.addChild(ambientLightNode);
        return group;
    }
    private void createView() {
        Box handle_1 = new Box(0.3f, 0.05f, 0.05f, getHandleAppearance("", new Color3f(0,0,0)));
        Vector3f vector_1 = new Vector3f(0.3f, -0.3f, 0.1f);
        TransformGroup tg_1 = new TransformGroup();
        Transform3D transform_1 = new Transform3D();
        transform_1.setTranslation(vector_1);
        tg_1.setTransform(transform_1);
        tg_1.addChild(handle_1);
        ViewTransformGroup.addChild(tg_1);

        Box handle_2 = new Box(0.3f, 0.05f, 0.05f, getHandleAppearance("", new Color3f(0,0,0)));
        Vector3f vector_2 = new Vector3f(0.25f, -0.3f, -0.3f);
        TransformGroup tg_2 = new TransformGroup();
        Transform3D transform_2 = new Transform3D();
        transform_2.setTranslation(vector_2);
        tg_1.setTransform(transform_2);
        tg_1.addChild(handle_2);
        ViewTransformGroup.addChild(tg_2);

        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        Sphere cone = new Sphere(0.20f);
        Vector3f vector = new Vector3f(0.72f, -0.3f, 0.1f);
        transform.setTranslation(vector);
        tg.setTransform(transform);
        tg.addChild(cone);
        ViewTransformGroup.addChild(tg);

        TransformGroup tg1 = new TransformGroup();
        Transform3D transform1 = new Transform3D();
        Sphere cone1 = new Sphere(0.20f);
        Vector3f vector1 = new Vector3f(0.05f, -0.3f, 0.1f);
        transform.setTranslation(vector1);
        tg.setTransform(transform1);
        tg.addChild(cone1);
        ViewTransformGroup.addChild(tg1);

        TransformGroup tg2 = new TransformGroup();
        Transform3D transform2 = new Transform3D();
        Sphere cone2 = new Sphere(0.20f);
        Vector3f vector2 = new Vector3f(0.72f, -0.3f, -0.3f);
        transform.setTranslation(vector2);
        tg.setTransform(transform2);
        tg.addChild(cone2);
        ViewTransformGroup.addChild(tg2);

        TransformGroup tg3 = new TransformGroup();
        Transform3D transform3 = new Transform3D();
        Sphere cone3 = new Sphere(0.20f);
        Vector3f vector3 = new Vector3f(0.05f, -0.3f, -0.3f);
        transform.setTranslation(vector3);
        tg.setTransform(transform3);
        tg.addChild(cone3);
        ViewTransformGroup.addChild(tg3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (rotateY) {
            treeTransform3D.rotY(angleY);
            angleY += 0.05;
            if (angleY >= 25) {
                rotateY = !rotateY;
                angleY = 0;
            }
        } else {
            treeTransform3D.rotX(angleX);
            angleX += 0.05;
            if (angleX >= 25) {
                rotateY = !rotateY;
                angleX = 0;
            }
        }
        ViewTransformGroup.setTransform(treeTransform3D);
    }

    private static Appearance getHandleAppearance(String picture, Color3f color) {
        Appearance ap = new Appearance();
        Color3f ambient = new Color3f(0.2f, 0, 0.2f);
        Color3f diffuse = new Color3f(0.7f, 0, 0.2f);
        Color3f specular = new Color3f(0.6f, 0.6f, 0.6f);
        ap.setMaterial(new Material(ambient, color, diffuse, specular, 1.0f));
        return ap;
    }
}