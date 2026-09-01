package com.gh4a.utils;

import android.os.Build;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadUtilsTest {
    @Test
    public void loadedContentIsSavedDirectlyOnAndroidSix() {
        assertThat(DownloadUtils.shouldSaveLoadedContent(Build.VERSION_CODES.M, "ZmlsZQ=="),
                is(true));
    }

    @Test
    public void missingContentFallsBackToAuthenticatedDownload() {
        assertThat(DownloadUtils.shouldSaveLoadedContent(Build.VERSION_CODES.M, ""), is(false));
    }

    @Test
    public void modernAndroidUsesDownloadManager() {
        assertThat(DownloadUtils.shouldSaveLoadedContent(Build.VERSION_CODES.Q, "ZmlsZQ=="),
                is(false));
    }
}
