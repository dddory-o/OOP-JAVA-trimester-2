package assignment_1;

// Abstract base class to enforce data abstraction
public abstract class Entity {
    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Abstract method for polymorphism
    public abstract String getDetails();

    // Override methods: equals, hashCode, and toString
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Entity ID: " + id;
    }
}

