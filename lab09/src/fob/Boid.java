package fob;

import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Boid {
    public static final int SPEED = 3;
    public static final int SEPARATION_DISTANCE = 20;
    public static final int NEIGHBOR_DISTANCE = 50;
    public static final int JOIN_THRESHOLD = 15;

    private Point position;
    private Point velocity;
    private int panelWidth;
    private int panelHeight;
    private Random random;

    public Boid(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.random = new Random();

        position = new Point(random.nextInt(panelWidth), random.nextInt(panelHeight));
        velocity = new Point(random.nextInt(2 * SPEED) - SPEED, random.nextInt(2 * SPEED) - SPEED);
    }

    public void flock(List<Boid> boids) {
        Point separation = separate(boids);
        Point alignment = align(boids);
        Point cohesion = cohere(boids);

        // Combine forces with weights
        velocity.translate((int)(separation.x * 1.5 + alignment.x * 1.0 + cohesion.x * 1.0),
                           (int)(separation.y * 1.5 + alignment.y * 1.0 + cohesion.y * 1.0));

        // Limit speed
        limitSpeed();
    }

    private Point separate(List<Boid> boids) {
        Point steer = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            int distance = (int) position.distance(other.position);
            if (other != this && distance > 0 && distance < SEPARATION_DISTANCE) {
                Point diff = new Point(position.x - other.position.x, position.y - other.position.y);
                steer.translate(diff.x / distance, diff.y / distance);
                count++;
            }
        }

        if (count > 0) {
            steer.x /= count;
            steer.y /= count;
        }
        return steer;
    }

    private Point align(List<Boid> boids) {
        Point avgVelocity = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                avgVelocity.translate(other.velocity.x, other.velocity.y);
                count++;
            }
        }

        if (count > 0) {
            avgVelocity.x /= count;
            avgVelocity.y /= count;
            avgVelocity.translate(-velocity.x, -velocity.y);
        }
        return avgVelocity;
    }

    private Point cohere(List<Boid> boids) {
        Point center = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                center.translate(other.position.x, other.position.y);
                count++;
            }
        }

        if (count > 0) {
            center.x /= count;
            center.y /= count;
            center.translate(-position.x, -position.y);
        }
        return center;
    }

    public void applyForce(Point force) {
        velocity.translate(force.x, force.y);
    }

    private void limitSpeed() {
        double magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        if (magnitude > SPEED) {
            velocity.x = (int) ((velocity.x / magnitude) * SPEED);
            velocity.y = (int) ((velocity.y / magnitude) * SPEED);
        }
    }

    public void update() {
        position.translate(velocity.x, velocity.y);
        // wrap-around at screen edges
        if (position.x < 0) position.x = panelWidth;
        else if (position.x > panelWidth) position.x = 0;
        if (position.y < 0) position.y = panelHeight;
        else if (position.y > panelHeight) position.y = 0;
    }

    // draw boid as a triangle (position, velocity)
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
   
        double angle = Math.atan2(velocity.y, velocity.x);
        
        g2d.translate(position.x, position.y);
        g2d.rotate(angle);

        int[] xPoints = {0, -10, -10};
        int[] yPoints = {0, -5, 5};
        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.rotate(-angle);
        g2d.translate(-position.x, -position.y);
    }

    public Point getPosition() { return position; }
    public Point getVelocity() { return velocity; }

    @Override
    public String toString() {
        return "{" +
            ", position='" + getPosition() + "'" +
            ", velocity='" + getVelocity() + "'" +
                        "}";
    } 
}
