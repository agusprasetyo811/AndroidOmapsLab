package com.omaps.lab.camera;

import java.io.File;

abstract class AlbumStorageDirFactory {
	public abstract File getAlbumStorageDir(String albumName);
}
