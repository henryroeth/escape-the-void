package com.henryroeth.escapethevoid;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.henryroeth.escapethevoid.entities.Platform;
import com.henryroeth.escapethevoid.entities.Player;

public class LevelLoader {
	
	public static class LevelData {
		public List<Platform> platforms = new ArrayList<>();
		public Player player;
		public int width, height;
	}
	
	private static final int TILE_SIZE = 40;
	
	public static LevelData loadLevel(String filename) {
		LevelData data = new LevelData();
		List<String> lines = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		data.height = lines.size() * TILE_SIZE;
		int maxWidth = 0;
		for (int y = 0; y < lines.size(); y++) {
			String line = lines.get(y);
			maxWidth = Math.max(maxWidth, line.length());
			for (int x = 0; x < line.length(); x++) {
				char c = line.charAt(x);
				if (c == '#') {
					// Check how many consecutive # we have
					int startX = x;
					while (x < line.length() && line.charAt(x) == '#') {
						x++;
					}
					int width = (x - startX) * TILE_SIZE;
					data.platforms.add(new Platform(startX * TILE_SIZE, y * TILE_SIZE, width, TILE_SIZE, Color.CYAN));
					x--; // Adjust for outer loop increment
				} else if (c == 'P') {
					data.player = new Player(x * TILE_SIZE, y * TILE_SIZE);
				}
			}
		}
		data.width = maxWidth * TILE_SIZE;
		
		return data;
	}
}
