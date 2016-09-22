package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa una tarjeta de Situacion
 */
class SituationCard {

    private String name;
    private String description;
    private SituationCardStrategy strategy;

    // Constructors ----------------------------
    public SituationCard(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters & Setters ----------------------------
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the strategy
     */
    public SituationCardStrategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(SituationCardStrategy strategy) {
        this.strategy = strategy;
    }
    
    // Methods ----------------------------
    
    /**
     * Metodo que ejecuta la accion de la estrategia
     */
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        this.getStrategy().executeAction(targetPlayer);
    }
    
    
    /**
     * Metodo que setea la estrategia de Amonestacion
     */
    public void setWarningStrategy() {
        this.setStrategy(new WarningStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Expulsion
     */
    public void setExpulsionStrategy() {
        this.setStrategy(new ExpulsionStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Offside
     */
    public void setOffsideStrategy() {
        this.setStrategy(new OffsideStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Cambio
     */
    public void setChangeStrategy() {
        this.setStrategy(new ChangeStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Tiro Libre
     */
    public void setFreeKickStrategy() {
        this.setStrategy(new FreeKickStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Penal
     */
    public void setPenaltyStrategy() {
        this.setStrategy(new PenaltyStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Lesion
     */
    public void setInjuryStrategy() {
        this.setStrategy(new InjuryStrategy());
    }
    
    /**
     * Metodo que setea la estrategia de Tiempo de Descuento
     */
    public void setTimeOffStrategy() {
        this.setStrategy(new TimeOffStrategy());
    }
    
}
