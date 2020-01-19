package Sepr2Assessment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;

class entityTests {

	@Test
	void UT_ENTITY_HEALTHCHANGE() {
		entityHealthTest changeTest = new entityHealthTest();
		changeTest.setCurrentHealth(0);
		changeTest.setMaxHealth(100);
		changeTest.changeHealth(10);
		assertEquals(changeTest.getCurrentHealth(), 10);
	}
	
	@Test
	void UT_ENTITY_HEALTHCHANGE_LIMIT() {
		entityHealthTest changeTest = new entityHealthTest();
		//v1
		changeTest.setCurrentHealth(100);
		changeTest.setMaxHealth(100);
		changeTest.changeHealth(10);
		assertEquals(changeTest.getCurrentHealth(), 100);
		//v2
		changeTest.setCurrentHealth(94);
		changeTest.setMaxHealth(100);
		changeTest.changeHealth(10);
		assertEquals(changeTest.getCurrentHealth(), 100);
		//v3
		changeTest.setCurrentHealth(0);
		changeTest.changeHealth(-10);
		assertEquals(changeTest.getCurrentHealth(), 0);
		//v4
		changeTest.setCurrentHealth(7);
		changeTest.changeHealth(-10);
		assertEquals(changeTest.getCurrentHealth(), 0);
	}
	
	@Test
	void UT_ENTITY_INRANGE() {
		entityRangeTest rangeTest = new entityRangeTest();
		//v1
		rangeTest.setLocationVector(new Vector2(0,0));
		assertTrue(rangeTest.isEntityinRange(new Vector2(0,0), new Vector2(1,1)));
		//v2
		rangeTest.setLocationVector(new Vector2(1,1));
		assertTrue(rangeTest.isEntityinRange(new Vector2(0,0), new Vector2(2,2)));
		//v3
		rangeTest.setLocationVector(new Vector2(1,1));
		assertFalse(rangeTest.isEntityinRange(new Vector2(2,2), new Vector2(2,3)));
		
	}
	
	@Test
	void UT_ENTITY_CANENTITYATTACKENTITY() {
		entityCanAttackTest attackerEntity = new entityCanAttackTest();
		entityCanAttackTest testEntity = new entityCanAttackTest();
		//v1
		attackerEntity.setCurrentHealth(20);
		attackerEntity.setInRange(true);
		assertTrue(attackerEntity.canEntityAttackEntity(testEntity));
		//v2
		attackerEntity.setCurrentHealth(0);
		attackerEntity.setInRange(true);
		assertFalse(attackerEntity.canEntityAttackEntity(testEntity));
		//v3
		attackerEntity.setCurrentHealth(20);
		attackerEntity.setInRange(false);
		assertFalse(attackerEntity.canEntityAttackEntity(testEntity));
		//v4
		assertFalse(attackerEntity.canEntityAttackEntity(null));
		
	}
	
	

}
