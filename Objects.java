class OLine{
    int x, y, x2, y2, w;
    OLine (int X, int Y, int X2, int Y2, int width){
        x = X;
        y = Y;
        x2 = X2;
        y2 = Y2;
        w = width;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public int getWidth(){return w;}
}

class OCircle{
    int x, y, r;
    OCircle (int X, int Y, int radius){
        x = X;
        y = Y;
        r = radius;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getRadius(){return r;}
}